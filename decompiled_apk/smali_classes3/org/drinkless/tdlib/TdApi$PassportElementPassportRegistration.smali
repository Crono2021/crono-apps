.class public Lorg/drinkless/tdlib/TdApi$PassportElementPassportRegistration;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementPassportRegistration"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x24dadc7f


# instance fields
.field public passportRegistration:Lorg/drinkless/tdlib/TdApi$PersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17556
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17557
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDocument;)V
    .locals 0
    .param p1, "personalDocument"    # Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17547
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17548
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementPassportRegistration;->passportRegistration:Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17549
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17553
    const v0, 0x24dadc7f

    return v0
.end method
