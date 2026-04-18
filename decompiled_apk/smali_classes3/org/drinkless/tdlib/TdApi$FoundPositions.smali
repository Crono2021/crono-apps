.class public Lorg/drinkless/tdlib/TdApi$FoundPositions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundPositions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4cc9ce0


# instance fields
.field public positions:[I

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25625
    return-void
.end method

.method public constructor <init>(I[I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "iArr"    # [I

    .line 25614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25615
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundPositions;->totalCount:I

    .line 25616
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundPositions;->positions:[I

    .line 25617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25621
    const v0, -0x4cc9ce0

    return v0
.end method
