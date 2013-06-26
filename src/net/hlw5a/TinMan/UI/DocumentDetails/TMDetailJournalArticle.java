package net.hlw5a.TinMan.UI.DocumentDetails;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.hlw5a.TinMan.Contributor.Person;
import net.hlw5a.TinMan.Documents.JournalArticle;
import net.hlw5a.TinMan.UI.Styles;

public class TMDetailJournalArticle extends JPanel {

	private static final long serialVersionUID = 2411242446747736356L;

	private static String newLine = System.getProperty("line.separator");
	
	private JTextArea title;
	private JTextArea authors;
	private JTextArea publication;
	private JTextArea pages;
	private JTextArea volume;
	private JTextArea issue;
	private JTextArea year;
	private JTextArea doi;
	
	private URL url;
	
	public TMDetailJournalArticle() {
		super(new GridBagLayout());
		
		title = createTextArea("[title]");
		title.setFont(Styles.fontBoldItalicLarge);
		JLabel titleLabel = createLabel(title, "Title:");
		
		authors = createTextArea("[authors]");
		authors.setLineWrap(true);
		JLabel authorsLabel = createLabel(authors, "Authors:");
		
		publication = createTextArea("[publication]");
		JLabel publicationLabel = createLabel(publication, "Publication:");
		
		pages = createTextArea("[pages]");
		JLabel pagesLabel = createLabel(pages, "Pages:");
		
		volume = createTextArea("[publisher]");
		JLabel volumeLabel = createLabel(volume, "Volume:");
		
		issue = createTextArea("[address]");
		JLabel issueLabel = createLabel(issue, "Issue:");
		
		year = createTextArea("[year]");
		JLabel yearLabel = createLabel(year, "Year:");
		
		doi = createTextArea("doi");
		doi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(url.toURI());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		JLabel doiLabel = createLabel(doi, "DOI:");
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		this.add(titleLabel, c);
		c.gridx = 1;
		c.gridwidth = 5;
		this.add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		this.add(authorsLabel, c);
		c.gridx = 1;
		c.gridwidth = 5;
		this.add(authors, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(publicationLabel, c);
		c.gridx = 1;
		c.gridwidth = 3;
		this.add(publication, c);
		
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(pagesLabel, c);
		c.gridx = 5;
		c.gridwidth = 1;
		this.add(pages, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		this.add(volumeLabel, c);
		c.gridx = 1;
		c.gridwidth = 1;
		this.add(volume, c);
		
		c.gridx = 2;
		c.gridwidth = 1;
		this.add(issueLabel, c);
		c.gridx = 3;
		c.gridwidth = 1;
		this.add(issue, c);
		
		c.gridx = 4;
		c.gridwidth = 1;
		this.add(yearLabel, c);
		c.gridx = 5;
		c.gridwidth = 1;
		this.add(year, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(doiLabel, c);
		c.gridx = 1;
		c.gridwidth = 5;
		this.add(doi, c);
	}
	
	public void setDocument(JournalArticle document) {
		title.setText(document.getTitle());
		authors.setText(convertContributors(document.getAuthors()));
		publication.setText(document.getPublication());
		pages.setText(document.getPages());
		volume.setText(document.getVolume());
		issue.setText(document.getIssue());
		year.setText(String.valueOf(document.getYear()));
		doi.setText(document.getDOI().getDoi());
		url = document.getDOI().getUrl();
	}
	
	private JTextArea createTextArea(String text) {
		JTextArea textArea = new JTextArea(text);
		textArea.setEditable(false);
		textArea.setBorder(Styles.borderCell);
		textArea.setFont(Styles.fontBold);
		return textArea;
	}
	
	private JLabel createLabel(Component c, String text) {
		JLabel label = new JLabel(text);
		label.setBorder(Styles.borderCell);
		label.setFont(Styles.fontItalic);
		label.setLabelFor(c);
		return label;
	}
	
	private String convertContributors(Iterator<Person> contributors) {
		StringBuilder result = new StringBuilder();
		while (contributors.hasNext()) {
			Person cont = contributors.next();
			result.append(cont.getLastName() + ", " + cont.getFirstNames());
			if (contributors.hasNext()) result.append(newLine);
		}
		return result.toString();
	}
}
