package org.sapient.loader.unmarshaller;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.sapient.model.criteria.DataCriteria;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author hgaur2
 *
 */
@Component
public class XMLDataUnmarshaller implements DataUnmarshaller {

	Gson gson;

	@Override
	public <V> Collection<V> unmarshal(DataCriteria<V> dataCriteria, Collection<String> xmls) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final Collection<V> collection = new ArrayList<>();

		try {
			final Transformer transformer = getTransformer(dataCriteria);
			final DocumentBuilder builder = factory.newDocumentBuilder();

			for (final String xml : xmls) {
				final Document document = builder.parse(new InputSource(new StringReader(xml)));

				final StringWriter writer = new StringWriter();
				final DOMSource source = new DOMSource(document);
				final StreamResult result = new StreamResult(writer);

				transformer.transform(source, result);
				final V value = gson.fromJson(writer.toString(), dataCriteria.getTo());

				collection.add(value);
			}

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collection;
	}

	private <V> Transformer getTransformer(final DataCriteria<V> criteria)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException {
		final File stylesheet = new File(criteria.getStyleSheet());
		final TransformerFactory tFactory = TransformerFactory.newInstance();
		final StreamSource stylesource = new StreamSource(stylesheet);
		final Transformer transformer = tFactory.newTransformer(stylesource);
		return transformer;
	}

	public <V> V unmarshal(DataCriteria<V> dataCriteria, String xml) {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			final Transformer transformer = getTransformer(dataCriteria);
			final DocumentBuilder builder = factory.newDocumentBuilder();

			final Document document = builder.parse(new InputSource(new StringReader(xml)));

			final StringWriter writer = new StringWriter();
			final DOMSource source = new DOMSource(document);
			final StreamResult result = new StreamResult(writer);

			transformer.transform(source, result);
			final V value = gson.fromJson(writer.toString(), dataCriteria.getTo());

			return value;

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@PostConstruct
	public void init() {
		gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
	}
}
