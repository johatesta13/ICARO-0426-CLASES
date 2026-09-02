import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

// Ejemplo: leer un Excel chico (usuarios_test.xlsx) fila por fila con un for,
// SIN Apache POI ni Maven. Un .xlsx no es más que un .zip con archivos XML
// adentro, así que lo abrimos con java.util.zip y parseamos el XML con las
// clases que ya trae el JDK (javax.xml). Cero dependencias externas.
public class For3B_LeerExcelSinDependencias {

    public static void main(String[] args) throws Exception {
        ZipFile xlsx = new ZipFile("/Users/johanatesta/Downloads/ICARO-0426-CLASES/CLASE-3/src/usuarios_test.xlsx");
        ZipEntry hoja = xlsx.getEntry("xl/worksheets/sheet1.xml");
        InputStream in = xlsx.getInputStream(hoja);

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(in);

        NodeList filas = doc.getElementsByTagName("row");

        // arrancamos en 1 (i=0 es el header con los nombres de columna)
        for (int i = 1; i < filas.getLength(); i++) {
            Element fila = (Element) filas.item(i);
            NodeList celdas = fila.getElementsByTagName("c");

            String usuario = obtenerTexto(celdas.item(0));
            String email = obtenerTexto(celdas.item(1));
            String rol = obtenerTexto(celdas.item(2));
            String activo = obtenerTexto(celdas.item(3));

            System.out.println("Usuario: " + usuario + " | Email: " + email
                    + " | Rol: " + rol + " | Activo: " + activo);

            // acá normalmente se llamaría al método de test correspondiente,
            // ej: login(usuario, password); o crearUsuarioEnBD(usuario, email, rol);
        }

        xlsx.close();
    }

    // cada celda con texto viene como <c t="inlineStr"><is><t>VALOR</t></is></c>
    private static String obtenerTexto(Node celda) {
        Element c = (Element) celda;
        Node t = c.getElementsByTagName("t").item(0);
        return t.getTextContent();
    }
}
