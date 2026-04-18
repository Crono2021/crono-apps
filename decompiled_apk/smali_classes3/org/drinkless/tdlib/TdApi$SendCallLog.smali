.class public Lorg/drinkless/tdlib/TdApi$SendCallLog;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendCallLog"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f0a47d1


# instance fields
.field public callId:I

.field public logFile:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30809
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 30798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30799
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendCallLog;->callId:I

    .line 30800
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendCallLog;->logFile:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 30801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30805
    const v0, 0x3f0a47d1

    return v0
.end method
