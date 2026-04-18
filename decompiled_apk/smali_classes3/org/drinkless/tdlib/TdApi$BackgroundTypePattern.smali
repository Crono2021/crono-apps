.class public Lorg/drinkless/tdlib/TdApi$BackgroundTypePattern;
.super Lorg/drinkless/tdlib/TdApi$BackgroundType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BackgroundTypePattern"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4ce716fd


# instance fields
.field public fill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

.field public intensity:I

.field public isInverted:Z

.field public isMoving:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42462
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 42463
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BackgroundFill;IZZ)V
    .locals 0
    .param p1, "backgroundFill"    # Lorg/drinkless/tdlib/TdApi$BackgroundFill;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 42450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BackgroundType;-><init>()V

    .line 42451
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypePattern;->fill:Lorg/drinkless/tdlib/TdApi$BackgroundFill;

    .line 42452
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypePattern;->intensity:I

    .line 42453
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypePattern;->isInverted:Z

    .line 42454
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$BackgroundTypePattern;->isMoving:Z

    .line 42455
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42459
    const v0, 0x4ce716fd    # 1.2115761E8f

    return v0
.end method
