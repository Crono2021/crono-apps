.class public Lorg/drinkless/tdlib/TdApi$TestReturnError;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestReturnError"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Error;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1b217cf2


# instance fields
.field public error:Lorg/drinkless/tdlib/TdApi$Error;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21060
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21061
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Error;)V
    .locals 0
    .param p1, "error"    # Lorg/drinkless/tdlib/TdApi$Error;

    .line 21051
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21052
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestReturnError;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 21053
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21057
    const v0, 0x1b217cf2

    return v0
.end method
