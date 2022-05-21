import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation


class MultiplierTest extends FreeSpec with ChiselScalatestTester {

  "Multiplier Gate Test" in {
    test(new MDU()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.src_a.poke(11.U)
      c.io.src_b.poke(2.U)
      c.io.valid.poke(1.B)
      c.io.op.poke(5.U)
      c.clock.step(1)
      c.io.valid.poke(0.B)

      c.clock.step(100)
      // c.io.output.bits.expect(25.S)
    }
  }
}




