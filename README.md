# fsm-lab
A small finite state machine example written primarily for teaching use.
This will be more like a framework than an application - the student will make changes to the program to effect desired changes

## Teaching Goals
- Demonstrate role of interfaces in modular design
-- FSM implementation(s) should just slot into the simulator
- Promote exploration of FSM based simulations
-- Students should be able to define FSM rules and layouts e.g.
--- Spreading Fire
--- Game of life
--- Growing plants
--- Predator & prey
- Provide controls for simulations
-- Possibly ways to push signals into the FSM

## Initial Features
- FSM interface(s)
- UI in terminal, Swing, JavaFX(?)
- Tick and animated modes

## Later Features
- Load and save workspace (simulation, configuration)

## Quality
- TDD there will be a full set of tests for the provided systems
-- Importantly, this will provide students with an initial set of tests for their own modified classes
- The software will be fully java-doc-umented
- In terms of code as written, it will err well on the side of legibility for novice programmers
-- This may mean that there is less indirection and use of terse syntax (e.g. lambdas) than might otherwise be used.
