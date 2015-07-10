package com.musiclibrary.shal.httpadapter;

import java.util.List;

import com.musiclibrary.shal.interfaces.MusicRestInterface;
import com.musiclibrary.shal.pojos.Artist;
import com.musiclibrary.shal.pojos.Genre;
import com.musiclibrary.shal.pojos.MusicLibrary;

public class MusicFMAHttpRestAdapter {

	private final MusicRestInterface<?> api;

	public MusicFMAHttpRestAdapter(MusicRestInterface<?> api) {
		this.api = api;
	}

	public List<Artist> getListOfArtist() {
		MusicLibrary<Artist> artistInfoFromServer = api.getArtists();
		return artistInfoFromServer.getDataset();
	}

	public List<Genre> getListOfGenre() {
		MusicLibrary<Genre> artistInfoFromServer = api.getGenres();
		return artistInfoFromServer.getDataset();
	}
}
