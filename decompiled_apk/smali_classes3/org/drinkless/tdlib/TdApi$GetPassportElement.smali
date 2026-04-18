.class public Lorg/drinkless/tdlib/TdApi$GetPassportElement;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPassportElement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PassportElement;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70331e86


# instance fields
.field public password:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26525
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;Ljava/lang/String;)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;
    .param p2, "str"    # Ljava/lang/String;

    .line 26514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26515
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPassportElement;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 26516
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetPassportElement;->password:Ljava/lang/String;

    .line 26517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26521
    const v0, -0x70331e86

    return v0
.end method
