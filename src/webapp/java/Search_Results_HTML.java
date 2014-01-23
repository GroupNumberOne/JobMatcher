package webapp.java;

public class Search_Results_HTML {
	
	public String getHTML(String string){
		String STRING ="<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"	<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\r\n" + 
			"	<title>JobMatcher</title>\r\n" + 
			"	<script type=\"text/javascript\" src=\"js/jquery-1.4.1.min.js\"></script>\r\n" + 
			"	<script type=\"text/javascript\" src=\"js/menu.js\"></script>\r\n" + 
			"	<script type=\"text/javascript\" src=\"js/slideshow.js\"></script>\r\n" + 
			"	<script type=\"text/javascript\" src=\"js/cufon-yui.js\"></script>\r\n" + 
			"	<script type=\"text/javascript\" src=\"js/Arial.font.js\"></script>\r\n" + 
			"	<script type=\"text/javascript\">\r\n" + 
			"		Cufon.replace('h1,h2,h3,h4,h5,#menu,#copy,.blog-date');\r\n" + 
			"	</script>\r\n" + 
			"	<script type=\"text/javascript\" charset=\"utf-8\">\r\n" + 
			"		$(document).ready(function() {\r\n" + 
			"			$('div.photo a').fancyZoom({directory: 'images/zoom', scaleImg: true, closeOnClick: true});\r\n" + 
			"		});\r\n" + 
			"	</script>\r\n" + 
			"	<link rel=\"stylesheet\" href=\"css/main.css\" type=\"text/css\" />\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<div id=\"bg\">\r\n" + 
			"		<div class=\"wrap\">\r\n" + 
			"			<h1><a href=\"index.html\">JobMatcher</a></h1>\r\n" + 
			"\r\n" + 
			"			<div id=\"mainmenu\">\r\n" + 
			"				<ul id=\"menu\">\r\n" + 
			"					<li><a href=\"index.html\">Home</a></li>\r\n" + 
			"					<li><a href=\"#\">Matchen</a>\r\n" + 
			"						<ul><li><a href=\"search_cv.html\">Zoek een CV</a></li><li><a href=\"search_vac.html\">Zoek een vacature</a></li><li></ul>\r\n" + 
			"					</li>\r\n" + 
			"<li><a href=\"#\">Dashboards</a>\r\n" +
			"<ul>" +
			"	<li><a href=\"http://infprj01-56.no-ip.org:8009/dashboard/bob\">Bob</a></li>" +
			"	<li><a href=\"http://infprj01-56.no-ip.org/dashboard/deborah/\">Deborah</a></li>" +
			"	<li><a href=\"http://infprj01-56.no-ip.org:8008/dashboard/patrick\">Patrick</a></li>" +
			"	<li><a href=\"http://infprj01-56.no-ip.org/dashboard/pepijn/\">Pepijn</a></li>" +
			"</ul>" +
			"</li>" +
			"					<li><a href=\"about.html\">Over ons</a></li>\r\n" + 
			"					<li><a href=\"contact.html\">Contact</a></li>\r\n" + 
			"				</ul>\r\n" + 
			"			</div>\r\n" + 
			"\r\n" + 
			"			<div id=\"pitch\">\r\n" + 
			"				<div id=\"slideshow\">\r\n" + 
			"					<div class=\"active\">\r\n" + 
			"						<img src=\"images/banner/Banner1.png\" width=960 height = 280 alt=\"\" />\r\n" + 
			"						<div class=\"overlay transparent\">\r\n" + 
			"							<h2>Professional Approach</h2>\r\n" + 
			"							<p>Zeer professioneel.</p>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"					<div>\r\n" + 
			"						<img src=\"images/banner/Banner2.png\" width=960 height = 280 alt=\"\" />\r\n" + 
			"						<div class=\"overlay transparent\">\r\n" + 
			"							<h2>Precise Methods</h2>\r\n" + 
			"							<p>Precisie zoals u nog nooit heeft gezien.</p>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"					<div>\r\n" + 
			"						<img src=\"images/banner/Banner3.png\" width=960 height = 280 alt=\"\" />\r\n" + 
			"						<div class=\"overlay transparent\">\r\n" + 
			"							<h2>Mesurable Results</h2>\r\n" + 
			"							<p>Resultaten waarvan uw mond open zal vallen.</p>\r\n" + 
			"						</div>\r\n" + 
			"					</div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"\r\n" + 
			"			<div id=\"main\">\r\n" + 
			"				<div id=\"intro\">\r\n" + 
								string + 
			"				</div>\r\n" + 
			"\r\n" + 
			"			</div>\r\n" + 
			"			\r\n" + 
			"			<div id=\"side\">\r\n" + 
			"				<h4>Laatste nieuws</h4>\r\n" + 
			"				<div class=\"news\">\r\n" + 
			"					<h5><a href=\"#\">Aantal cv's</a></h5>\r\n" + 
			"					<p>Er zijn inmiddels al meer dan 1000 cv's te vinden met JobMatcher!</p>\r\n" + 
			"				</div>\r\n" + 
			"				<div class=\"news\">\r\n" + 
			"					<h5><a href=\"#\">Start JobMatcher</a></h5>\r\n" + 
			"					<p>JobMatcher is vanaf nu officiëel beschikbaar!</p>\r\n" + 
			"				</div>\r\n" + 
			"			</div> \r\n" + 
			"		</div>\r\n" + 
			"			\r\n" + 
			"		<div id=\"footer\">\r\n" + 
			"			<div id=\"footerbg\">\r\n" + 
			"				<div class=\"wrap\">\r\n" + 
			"					<p id=\"footer_menu\">\r\n" + 
			"						<a href=\"#\">Informatie over uw privacy</a>\r\n" + 
			"						<a href=\"#\">&#169; Groep 1 </a>\r\n" + 
			"					</p>\r\n" + 
			"					<p id=\"copy\">JobMatcher <span>voor de beste matches</span></p>\r\n" + 
			"					<div class=\"clear\"></div>\r\n" + 
			"				</div>\r\n" + 
			"			</div>\r\n" + 
			"		</div>\r\n" + 
			"	</div>\r\n" + 
			"</body>\r\n" + 
			"</html>";
		return STRING;
	}
}
