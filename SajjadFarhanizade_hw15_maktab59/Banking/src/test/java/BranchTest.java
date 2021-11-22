import entity.Branch;
import manager.BranchManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BranchTest {
    BranchManager branchManager = new BranchManager(DbConnection.getEntityManager());
    @Test
    void test_create_account(){
        Branch branch = Branch.builder()
                .name("1")
                .build();
        branchManager.save(branch);
        long id = branchManager.loadById(branch.getId()).getId();
        assertEquals(id,branch.getId());
    }
}
