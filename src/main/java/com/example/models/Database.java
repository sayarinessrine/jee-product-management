package com.example.models;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private final String url="jdbc:mysql://localhost:3307/jee";
    private final String username="root";
    private final String password="root";
    private Connection con;
    private Statement st;

   public Database()throws ClassNotFoundException{
       Class.forName("com.mysql.cj.jdbc.Driver");
   }
   public void connect()throws SQLException{
       con=DriverManager.getConnection(url,username,password);
   }
   public boolean verifier(String email,String password)throws SQLException {
       st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from utilisateur where email='"+email+"'and password='"+password+"'");
       if(rs.next()){
           return true;
       }else{
           return false;
       }
   }
    public void insertCat(Categorie c) throws SQLException {
        st=con.createStatement();
        String query = "INSERT INTO categorie (nomcat,date) VALUES ('" + c.getNomcat() + "', '" + c.getDate() + "')";

        st.executeUpdate(query);
    }
    public void insertProd(Produit p) throws SQLException {
        st=con.createStatement();
        String query = "INSERT INTO produits (nom,prix,idcat) VALUES ('" + p.getNom() + "', '" + p.getPrix()+ "','"+ p.getIdcat()+ "')";

        st.executeUpdate(query);
    }
    public List<Categorie> selectCat()throws SQLException{
        st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from categorie");
        List<Categorie>lc=new ArrayList<>();
        while (rs.next()){
            int id=rs.getInt(1);
            Date date=rs.getDate(2);
            String nom=rs.getString(3);
            Categorie c=new Categorie(id,nom,date);
            lc.add(c);
        }return lc;}
    public List<Produit> selectProd()throws SQLException{
        st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT p.id, p.prix, p.nom, p.idcat, c.nomcat FROM produits p,categorie c where p.idcat = c.idcat");
        List<Produit>lp=new ArrayList<>();
        while (rs.next()){
            int id=rs.getInt("id");
            String nom=rs.getString("nom");
            double prix= rs.getDouble("prix");
            int idcat=rs.getInt("idcat");
            String nomcat=rs.getString("nomcat");
            Produit c=new Produit(id,nom,prix,idcat,nomcat);
            lp.add(c);
        }return lp;}
    public Produit selectProduitById(int id) throws SQLException {
        String query = "SELECT p.id, p.prix, p.nom, p.idcat, c.nomcat FROM produits p, categorie c WHERE p.idcat = c.idcat AND p.id = " + id;

        st= con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            int i = rs.getInt("id");
            String nom = rs.getString("nom");
            double prix = rs.getDouble("prix");
            int idcat = rs.getInt("idcat");
            String nomcat = rs.getString("nomcat");
            return new Produit(i, nom, prix, idcat, nomcat);
        } else {
            return null;
            }
        }
    public List<Produit> getProduitsByCategorieId(int idCat) throws ClassNotFoundException, SQLException {
           List<Produit> produits = new ArrayList<>();
           st = con.createStatement();
           String sql = "SELECT * FROM produits WHERE idcat = " + idCat;
           ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("prix");

                Produit produit = new Produit(id,nom, prix);
                produits.add(produit);
            }
        return produits;
    }
    public Categorie selectCategorietById(int id) throws SQLException {
        String query = "SELECT idcat, date,nomcat FROM categorie WHERE idcat = " + id;

        st= con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            int idcat = rs.getInt("idcat");
            String nomcat = rs.getString("nomcat");
            Date date=rs.getDate("date");
            return new Categorie(idcat,nomcat,date);
        } else {
            return null;
        }
    }

    public int countProduits() throws SQLException {
        int count = 0;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM produits");
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
    public int countCategorie() throws SQLException {
        int count = 0;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM categorie");
        if (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }
    public double calculerPrixMax() throws SQLException {
        double prixMax = 0.0;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MAX(prix) FROM produits");
        if (rs.next()) {
            prixMax = rs.getDouble(1);
        }
        return prixMax;
    }
    public double calculerPrixMin() throws SQLException {
        double prixMax = 0.0;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT MIN(prix) FROM produits");
        if (rs.next()) {
            prixMax = rs.getDouble(1);
        }
        return prixMax;
    }
    public int updateProd(Produit p) throws SQLException {
        String query = "update produits set nom='" + p.getNom() + "', prix='" + p.getPrix() +"', idcat='" + p.getIdcat() + "' where id=" + p.getId();
        st = con.createStatement();
        int rs = st.executeUpdate(query);
        st.close();
        return rs;
    }
    public int updateCat(Categorie c) throws SQLException {
        String query = "update categorie set nomcat='" + c.getNomcat() + "', date='" + c.getDate() + "' where idcat=" + c.getId();
        st = con.createStatement();
        int rs = st.executeUpdate(query);
        st.close();
        return rs;
    }

    public int supprimerProduit(int id) throws SQLException {
        String query = "delete from Produits where id=" + id;
        st = con.createStatement();
        int rs = st.executeUpdate(query);
        st.close();
        return rs;
    }
    public int supprimerCat(int id) throws SQLException {
        String query = "delete from categorie where idcat=" + id;
        st = con.createStatement();
        int rs = st.executeUpdate(query);
        st.close();
        return rs;
    }
   /* public void insertProd(Produit p) throws SQLException {
        st=con.createStatement();
        String query = "INSERT INTO Produit (nom,prix,) VALUES ('" + c.getNOMCAT() + "', '" + c.getDATECAT() + "')";

        st.executeUpdate(query);
    }*/


}
