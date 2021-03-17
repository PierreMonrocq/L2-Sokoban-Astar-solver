package ressources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONArray;
import org.json.JSONObject;

public class LecteurJSON {
	private static JSONObject obj;

	public LecteurJSON(String filename) {
		String donneJSON = lireFichier(filename);
		obj = new JSONObject(donneJSON);
	}

	public static String lireFichier(String filename) {
		String result = "";
		try {
			Reader reader = new InputStreamReader(loadJSON(filename));
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String lirePropriete(String categorie, String param) {
		JSONArray ja = obj.getJSONArray(categorie);
		return ja.getJSONObject(0).get(param).toString();
	}

	public static String lirePropriete(String categorie, String Couleur, String param) {
		JSONObject ja = obj.getJSONObject(categorie);
		JSONArray themes = ja.getJSONArray(Couleur);
		return themes.getJSONObject(0).get(param).toString();
	}

	public static String[] lireCouleur() {
		JSONObject ja = obj.getJSONObject("theme");
		String themes = ja.getString("ListeCouleur");
		String[] th = themes.toString().split(" ");
		return th;
	}

	private static InputStream loadJSON(String file) {
		InputStream fstream = LecteurJSON.class.getResourceAsStream(file);
		return fstream;
	}
}
