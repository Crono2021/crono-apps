.class public Lorg/drinkless/tdlib/TdApi$SetLogStream;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetLogStream"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5150086f


# instance fields
.field public logStream:Lorg/drinkless/tdlib/TdApi$LogStream;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19752
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19753
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$LogStream;)V
    .locals 0
    .param p1, "logStream"    # Lorg/drinkless/tdlib/TdApi$LogStream;

    .line 19743
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19744
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetLogStream;->logStream:Lorg/drinkless/tdlib/TdApi$LogStream;

    .line 19745
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19749
    const v0, -0x5150086f

    return v0
.end method
