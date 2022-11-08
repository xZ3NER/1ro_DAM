<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
<html>
<body>
    <center>
    <h1>Mis CD's</h1>
    <table border="1" style="width:98vw">
        <tr bgcolor="#887788">
            <th>Titulo</th>
            <th>Artista</th>
            <th>Sello</th>
            <th>Año</th>
            <th>Canciones</th>
        </tr>
        <xsl:for-each select="cdteca/cd">
            <tr>
                <td><xsl:value-of select="titulo"/></td>
                <td><xsl:value-of select="artista"/></td>
                <td><xsl:value-of select="sello"/></td>
                <td><xsl:value-of select="año"/></td>
                <td>
                    <xsl:for-each select="canciones">
                        <xsl:value-of select="."/>
                        &#160;
                        <xsl:value-of select="@tiempo"/>
                        <br/>
                    </xsl:for-each>
                </td>
            </tr>
        </xsl:for-each>
    </table>
    </center>
</body>
</html>
        </xsl:template>
        </xsl:stylesheet>