.class public Lorg/drinkless/tdlib/TdApi$SendCustomRequest;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendCustomRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CustomRequestResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x10fd71a1


# instance fields
.field public method:Ljava/lang/String;

.field public parameters:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30849
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 30838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30839
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendCustomRequest;->method:Ljava/lang/String;

    .line 30840
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendCustomRequest;->parameters:Ljava/lang/String;

    .line 30841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30845
    const v0, 0x10fd71a1

    return v0
.end method
