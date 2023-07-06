<?xml version="1.0" encoding="UTF-8"?>
<!-- xsl 문서 : XSLT 데이터를 저장한 XML 문서 - 일종의 템플릿 페이지-->
<!-- XSLT(Extensible Stylesheet Language Template) :XML 기반의 언어로 작성된 파서(Parser - 값을 해석)
=> xml 데이터를 전달받아 HTML 또는 XML데이터로 변환하는 정보 제공-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" encoding="utf-8"/>
	<xsl:template match="books">
		<!-- 변환될 문서의 스타일 작성 -->
		<ol>
			<xsl:for-each select="book">
				<li><b><xsl:value-of select="title"/></b><xsl:value-of select="author"/></li>
			</xsl:for-each>
		</ol>		
	</xsl:template>
</xsl:stylesheet>