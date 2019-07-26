/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 LE SAUCE Julien
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.jls.sod.core.cmd;

import org.jls.sod.core.model.Sense;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "smell", description = "Use your nose to smell something, in a direction or an object to get more information if possible")
public class Smell extends SenseBase {

    @Parameters(paramLabel = "target", arity = "0..1", defaultValue = "null", description = "The direction or the object to point your nose at")
    protected String target;

    public Smell(CommandController commandController) {
        super(commandController);
        this.sense = Sense.SMELL;
    }

    @Override
    public String apply(ParsedCommand command) {
        if (command.getContext().isUsageHelpRequested()) {
            printHelp(command);
            return "";
        }
        return applyCommandWith(this.sense, command);
    }
}