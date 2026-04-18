.class public Lorg/drinkless/tdlib/TdApi$PassportElementError;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementError"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6efa603b


# instance fields
.field public message:Ljava/lang/String;

.field public source:Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;

.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38899
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "passportElementErrorSource"    # Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;

    .line 38887
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38888
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementError;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 38889
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PassportElementError;->message:Ljava/lang/String;

    .line 38890
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PassportElementError;->source:Lorg/drinkless/tdlib/TdApi$PassportElementErrorSource;

    .line 38891
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38895
    const v0, -0x6efa603b

    return v0
.end method
