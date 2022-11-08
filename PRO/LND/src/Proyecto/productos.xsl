<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="productos.css"/>
                <meta charset="UTF-8"/>
                <title>Productos</title>
            </head>
            <body>
                <center>
                    <h1>Productos</h1>
                    <table border="1" style="width:98vw">
                        <tr bgcolor="87D6F0">
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Categoría</th>
                            <th>Precio</th>
                            <th>Ingredientes</th>
                        </tr>
                        <xsl:for-each select="productos/producto">
                            <tr>
                                <td><xsl:value-of select="codigo"/></td>
                                <td><xsl:value-of select="nombre"/></td>
                                <td><xsl:value-of select="categoria"/></td>
                                <td><xsl:value-of select="precio"/></td>
                                <td>
                                    <xsl:for-each select="ingredientes/ingrediente">
                                        <xsl:value-of select="."/>
                                        &#160;
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