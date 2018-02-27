package test.milorad.yatprojects.network.models;

public abstract class ApiResponse <T> {

	private Status STATUS;
	private T data;

	public Status getStatus() {
		return STATUS;
	}

	public T getData() {
		return data;
	}

	enum Status {
		OK,
		ERROR
	}
}
