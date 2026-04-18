.class public Lorg/drinkless/tdlib/TdApi$MessagePositions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePositions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73109559


# instance fields
.field public positions:[Lorg/drinkless/tdlib/TdApi$MessagePosition;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28565
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$MessagePosition;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messagePositionArr"    # [Lorg/drinkless/tdlib/TdApi$MessagePosition;

    .line 28554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28555
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePositions;->totalCount:I

    .line 28556
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessagePositions;->positions:[Lorg/drinkless/tdlib/TdApi$MessagePosition;

    .line 28557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28561
    const v0, -0x73109559

    return v0
.end method
