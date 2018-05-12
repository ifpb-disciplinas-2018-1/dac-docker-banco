package ifpb.dac.infra;

import ifpb.dac.domain.Cliente;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/05/2018, 07:28:38
 */
public class ClientesEmMemoria {

    public List<Cliente> todos() {
        return Arrays.asList(
                Cliente.of(1, "Kiko", "123"),
                Cliente.of(2, "Chaves", "234"),
                Cliente.of(3, "Chiquinha", "236")
        );
    }
}
