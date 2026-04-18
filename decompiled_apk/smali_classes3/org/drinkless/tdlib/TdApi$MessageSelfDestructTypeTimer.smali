.class public Lorg/drinkless/tdlib/TdApi$MessageSelfDestructTypeTimer;
.super Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSelfDestructTypeTimer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x508d57cd


# instance fields
.field public selfDestructTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16710
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;-><init>()V

    .line 16711
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16701
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;-><init>()V

    .line 16702
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSelfDestructTypeTimer;->selfDestructTime:I

    .line 16703
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16707
    const v0, 0x508d57cd

    return v0
.end method
