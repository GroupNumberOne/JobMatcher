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
			"	<link rel=\"stylesheet\" href=\"css/main.css\" type=\"text/css\" />\r\n" + 
			"<style>.CSSTableGenerator {\r\n" + 
			"	margin:0px;padding:0px;\r\n" + 
			"	width:100%;\r\n" + 
			"	border:0px solid #000000;\r\n" + 
			"	\r\n" + 
			"	-moz-border-radius-bottomleft:0px;\r\n" + 
			"	-webkit-border-bottom-left-radius:0px;\r\n" + 
			"	border-bottom-left-radius:0px;\r\n" + 
			"	\r\n" + 
			"	-moz-border-radius-bottomright:0px;\r\n" + 
			"	-webkit-border-bottom-right-radius:0px;\r\n" + 
			"	border-bottom-right-radius:0px;\r\n" + 
			"	\r\n" + 
			"	-moz-border-radius-topright:0px;\r\n" + 
			"	-webkit-border-top-right-radius:0px;\r\n" + 
			"	border-top-right-radius:0px;\r\n" + 
			"	\r\n" + 
			"	-moz-border-radius-topleft:0px;\r\n" + 
			"	-webkit-border-top-left-radius:0px;\r\n" + 
			"	border-top-left-radius:0px;\r\n" + 
			"}.CSSTableGenerator table{\r\n" + 
			"    border-collapse: collapse;\r\n" + 
			"        border-spacing: 0;\r\n" + 
			"	width:100%;\r\n" + 
			"	height:100%;\r\n" + 
			"	margin:0px;padding:0px;\r\n" + 
			"}.CSSTableGenerator tr:last-child td:last-child {\r\n" + 
			"	-moz-border-radius-bottomright:0px;\r\n" + 
			"	-webkit-border-bottom-right-radius:0px;\r\n" + 
			"	border-bottom-right-radius:0px;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator table tr:first-child td:first-child {\r\n" + 
			"	-moz-border-radius-topleft:0px;\r\n" + 
			"	-webkit-border-top-left-radius:0px;\r\n" + 
			"	border-top-left-radius:0px;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator table tr:first-child td:last-child {\r\n" + 
			"	-moz-border-radius-topright:0px;\r\n" + 
			"	-webkit-border-top-right-radius:0px;\r\n" + 
			"	border-top-right-radius:0px;\r\n" + 
			"}.CSSTableGenerator tr:last-child td:first-child{\r\n" + 
			"	-moz-border-radius-bottomleft:0px;\r\n" + 
			"	-webkit-border-bottom-left-radius:0px;\r\n" + 
			"	border-bottom-left-radius:0px;\r\n" + 
			"}.CSSTableGenerator tr:hover td{\r\n" + 
			"	\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator tr:nth-child(odd){ background-color:#e5e5e5; }\r\n" + 
			".CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }.CSSTableGenerator td{\r\n" + 
			"	vertical-align:middle;\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"	border:1px solid #000000;\r\n" + 
			"	border-width:0px 1px 1px 0px;\r\n" + 
			"	text-align:left;\r\n" + 
			"	padding:7px;\r\n" + 
			"	font-size:12px;\r\n" + 
			"	font-family:Arial;\r\n" + 
			"	font-weight:normal;\r\n" + 
			"	color:#000000;\r\n" + 
			"}" +
			".CSSTableGenerator td a{\r\n" + 
			"text-decoration: underline;\r\n" + 
			"}"
			+ ".CSSTableGenerator tr:last-child td{\r\n" + 
			"	border-width:0px 1px 0px 0px;\r\n" + 
			"}.CSSTableGenerator tr td:last-child{\r\n" + 
			"	border-width:0px 0px 1px 0px;\r\n" + 
			"}.CSSTableGenerator tr:last-child td:last-child{\r\n" + 
			"	border-width:0px 0px 0px 0px;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator tr:first-child td{\r\n" + 
			"		background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );\r\n" + 
			"	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );\r\n" + 
			"	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=\"#cccccc\", endColorstr=\"#b2b2b2\");	background: -o-linear-gradient(top,#cccccc,b2b2b2);\r\n" + 
			"\r\n" + 
			"	background-color:#cccccc;\r\n" + 
			"	border:0px solid #000000;\r\n" + 
			"	text-align:center;\r\n" + 
			"	border-width:0px 0px 1px 1px;\r\n" + 
			"	font-size:14px;\r\n" + 
			"	font-family:Arial;\r\n" + 
			"	color:#000000;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator tr:first-child:hover td{\r\n" + 
			"	background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );\r\n" + 
			"	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );\r\n" + 
			"	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=\"#cccccc\", endColorstr=\"#b2b2b2\");	background: -o-linear-gradient(top,#cccccc,b2b2b2);\r\n" + 
			"\r\n" + 
			"	background-color:#cccccc;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator tr:first-child td:first-child{\r\n" + 
			"	border-width:0px 0px 1px 0px;\r\n" + 
			"}\r\n" + 
			".CSSTableGenerator tr:first-child td:last-child{\r\n" + 
			"	border-width:0px 0px 1px 1px;\r\n" + 
			"} </style>" +
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
			"<li><a href=\"#\">Dashboards</a>" +
			"	<ul>" +
			"		<li><a href=\"http://infprj01-56.no-ip.org:8009/dashboard/bob\">Bob</a></li>" +
			"		<li><a href=\"http://infprj01-56.no-ip.org/dashboard/deborah/\">Deborah</a></li>"+
			"		<li><a href=\"http://infprj01-56.no-ip.org:8008/dashboard/patrick\">Patrick</a></li>" +
			"		<li><a href=\"http://infprj01-56.no-ip.org/dashboard/pepijn/\">Pepijn</a></li>" +
			"		</ul>"+
			"</li>"+
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
			"							<h2>Measurable Results</h2>\r\n" + 
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
			"					<p>JobMatcher is vanaf nu offici&#235;el beschikbaar!</p>\r\n" + 
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
