package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conexao.Conexao;
import model.entity.Paises;

public class PaisesDAO {

    public static List<Paises> listarPaises() {

        String sql = "SELECT * FROM paises";
        List<Paises> paises = new ArrayList<>();

        try (Connection connection = new Conexao().conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paises pais = new Paises();
                pais.setId(rs.getInt("id"));
                pais.setNome(rs.getString("nome"));
                pais.setArea(rs.getInt("area"));
                pais.setPopulação(rs.getDouble("população"));
                pais.setPib(rs.getDouble("pib"));
                pais.setExpectativaDeVida(rs.getDouble("expectativaDeVida"));
                pais.setMedalhasOlimpicas(rs.getInt("MedalhasOlimpicas"));
                paises.add(pais);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paises;
    }

    public Paises procurarPaisPorId(int id) {
        String sql = "SELECT * FROM paises WHERE ID = ?";
        Paises pais = null;

        try (Connection connection = new Conexao().conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pais = new Paises();
                pais.setId(rs.getInt("id"));
                pais.setNome(rs.getString("nome"));
                pais.setArea(rs.getInt("area"));
                pais.setPopulação(rs.getDouble("população"));
                pais.setPib(rs.getDouble("pib"));
                pais.setExpectativaDeVida(rs.getDouble("expectativaDeVida"));
                pais.setMedalhasOlimpicas(rs.getInt("MedalhasOlimpicas"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pais;
    }

    public void atualizarPais(Paises pais) {
        String sql = "UPDATE paises SET Nome = ?, Area = ?, Populacao = ?, PIB = ?, Expectativa_Vida = ?, Medalhas_Olimpicas = ? WHERE ID = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pais.getNome());
            stmt.setDouble(2, pais.getArea());
            stmt.setDouble(3, pais.getPopulação());
            stmt.setDouble(4, pais.getPib());
            stmt.setDouble(5, pais.getExpectativaDeVida());
            stmt.setInt(6, pais.getMedalhasOlimpicas());
            stmt.setInt(7, pais.getId());

            stmt.executeUpdate();
            System.out.println("País atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar país.");
        }
    }

    public void excluirPais(int id) {
        String sql = "DELETE FROM paises WHERE ID = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("País excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao excluir país.");
        }
    }

}
