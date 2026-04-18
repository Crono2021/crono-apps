.class public Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportRequiredElement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x763bf833


# instance fields
.field public suitableElements:[Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17682
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17683
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;)V
    .locals 0
    .param p1, "passportSuitableElementArr"    # [Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;

    .line 17673
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17674
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportRequiredElement;->suitableElements:[Lorg/drinkless/tdlib/TdApi$PassportSuitableElement;

    .line 17675
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17679
    const v0, -0x763bf833

    return v0
.end method
