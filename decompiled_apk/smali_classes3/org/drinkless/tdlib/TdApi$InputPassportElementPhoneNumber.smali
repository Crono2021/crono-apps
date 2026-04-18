.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementPhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementPhoneNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ea3cc39


# instance fields
.field public phoneNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15090
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15091
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15081
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15082
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementPhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 15083
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15087
    const v0, 0x4ea3cc39

    return v0
.end method
