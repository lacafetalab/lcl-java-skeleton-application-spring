package pe.lacafetalab.pao.shared.framework;

public final class ApplicationContext {

	private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<Context>() {

		@Override
		protected Context initialValue() {
			return new Context();
		}

	};

	private ApplicationContext() {

	}

	public static void remove() {
		ApplicationContext.THREAD_LOCAL.remove();
	}

	public static Context getContext() {
		return ApplicationContext.THREAD_LOCAL.get();
	}

}
