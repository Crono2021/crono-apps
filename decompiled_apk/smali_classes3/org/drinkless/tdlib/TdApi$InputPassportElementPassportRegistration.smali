.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementPassportRegistration;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementPassportRegistration"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e5aa050


# instance fields
.field public passportRegistration:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15055
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;)V
    .locals 0
    .param p1, "inputPersonalDocument"    # Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15045
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15046
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementPassportRegistration;->passportRegistration:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15047
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15051
    const v0, 0x4e5aa050    # 9.169848E8f

    return v0
.end method
