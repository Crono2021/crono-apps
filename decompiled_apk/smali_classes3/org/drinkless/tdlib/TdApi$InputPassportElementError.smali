.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementError;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementError"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x11084de2


# instance fields
.field public message:Ljava/lang/String;

.field public source:Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;

.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38019
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "inputPassportElementErrorSource"    # Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;

    .line 38007
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38008
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementError;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 38009
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementError;->message:Ljava/lang/String;

    .line 38010
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementError;->source:Lorg/drinkless/tdlib/TdApi$InputPassportElementErrorSource;

    .line 38011
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38015
    const v0, 0x11084de2

    return v0
.end method
