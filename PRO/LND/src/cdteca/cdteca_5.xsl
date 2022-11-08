<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
<html>
    <head>
        <style>
            tr td {
                transition: all .5s;
                text-align: center;
                top:0;
                right:0;
                background-color:lightgrey;
            }

            tr td:hover {
                position: relative;
                top: 5px;
                right:-5px;
                background-color: black;
                color: white;
            }
        </style>
    </head>
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
            <th>Tiempo</th>
        </tr>
        <xsl:for-each select="cdteca/cd">
           <xsl:variable name="titulo"><xsl:value-of select="titulo"/></xsl:variable>
            <xsl:variable name="artista"><xsl:value-of select="artista"/></xsl:variable>
            <xsl:variable name="sello"><xsl:value-of select="sello"/></xsl:variable>
            <xsl:variable name="año"><xsl:value-of select="año"/></xsl:variable>
            <xsl:for-each select="canciones">
                <xsl:if test="@tiempo &lt; 180">
                    <tr>
                        <td><xsl:value-of select="$titulo"/></td>
                        <td><xsl:value-of select="$artista"/></td>
                        <td><xsl:value-of select="$sello"/></td>
                        <td><xsl:value-of select="$año"/></td>
                        <td><xsl:value-of select="."/><br/></td>
                        <td><xsl:value-of select="@tiempo"/></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>
        </xsl:for-each>
    </table>
    </center>
</body>
</html>
        </xsl:template>
        </xsl:stylesheet>