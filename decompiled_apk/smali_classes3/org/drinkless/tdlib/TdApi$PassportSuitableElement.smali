.class public Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportSuitableElement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f077ce4


# instance fields
.field public isNativeNameRequired:Z

.field public isSelfieRequired:Z

.field public isTranslationRequired:Z

.field public type:Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44550
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44551
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PassportElementType;ZZZ)V
    .locals 0
    .param p1, "passportElementType"    # Lorg/drinkless/tdlib/TdApi$PassportElementType;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z

    .line 44538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44539
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;->type:Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 44540
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;->isSelfieRequired:Z

    .line 44541
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;->isTranslationRequired:Z

    .line 44542
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;->isNativeNameRequired:Z

    .line 44543
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44547
    const v0, -0x2f077ce4

    return v0
.end method
