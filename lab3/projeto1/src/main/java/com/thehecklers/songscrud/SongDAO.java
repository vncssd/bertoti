package com.thehecklers.songscrud;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SongDAO {

    public Song salvar(Song song){
        String sql = "INSERT INTO songs (id, name, artists, duration) VALUES(?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, song.getId());
            ps.setString(2, song.getName());
            ps.setArray(3, toSqlArray(conn, song.getArtists()));
            ps.setInt(4, song.getDuration());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar música: " + e.getMessage(), e);
        }
        return song;
    }

    public List<Song> buscarTodos(){
        String sql = "SELECT * FROM songs ORDER BY name";
        List<Song> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as músicas: " + e.getMessage(), e);
        }
        return lista;
    }

    public Song buscarPorId(UUID id){
        String sql = "SELECT * FROM songs WHERE id = ?";
        Song song = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    song = mapear(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar música por ID: " + e.getMessage(), e);
        }
        return song;
    }

    public Song apagar(Song song){
        String sql = "DELETE FROM songs WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setObject(1, song.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar música: " + e.getMessage(), e);
        }
        return song;
    }

    public Song atualizar(Song song){
        String sql = "UPDATE songs SET name = ?, artists = ?, duration = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, song.getName());
            ps.setArray(2, toSqlArray(conn, song.getArtists()));
            ps.setInt(3, song.getDuration());
            ps.setObject(4, song.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar música: " + e.getMessage(), e);
        }
        return song;
    }

    private Song mapear(ResultSet rs) throws SQLException {
        Song song = new Song();
        song.setId((UUID) rs.getObject("id"));
        song.setName(rs.getString("name"));

        Array artistsArray = rs.getArray("artists");
        List<String> artists = new ArrayList<>();
        if (artistsArray != null) {
            artists.addAll(Arrays.asList((String[]) artistsArray.getArray()));
        }
        song.setArtists(artists);
        song.setDuration(rs.getInt("duration"));
        return song;
    }

    private Array toSqlArray(Connection conn, List<String> artists) throws SQLException {
        List<String> lista = artists == null ? new ArrayList<>() : artists;
        return conn.createArrayOf("text", lista.toArray(new String[0]));
    }
}
