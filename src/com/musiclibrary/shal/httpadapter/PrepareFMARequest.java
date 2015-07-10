package com.musiclibrary.shal.httpadapter;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.musiclibrary.shal.interfaces.MusicRestInterface;
import com.musiclibrary.shal.pojos.Artist;
import com.musiclibrary.shal.pojos.Genre;

public class PrepareFMARequest {
	private static PrepareFMARequest prepareRequest;
	private final RestAdapter restAdapter;
	private final Gson gson;
	private final MusicRestInterface<?> api;

	private PrepareFMARequest() {
		gson = new GsonBuilder().setFieldNamingPolicy(
				FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		restAdapter = new RestAdapter.Builder()
				.setConverter(new GsonConverter(gson))
				.setEndpoint("http://freemusicarchive.org/api").build();
		api = restAdapter.create(MusicRestInterface.class);
	}

	public static PrepareFMARequest getInstance() {
		if (prepareRequest == null) {
			prepareRequest = new PrepareFMARequest();
		}
		return prepareRequest;
	}

	public List<Artist> getArtistList() {
		MusicFMAHttpRestAdapter fmaAdapter = new MusicFMAHttpRestAdapter(api);
		return fmaAdapter.getListOfArtist();
	}

	public List<Genre> getGenreList() {
		MusicFMAHttpRestAdapter fmaAdapter = new MusicFMAHttpRestAdapter(api);
		return fmaAdapter.getListOfGenre();
	}
}
