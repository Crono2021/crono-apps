.class public Lorg/drinkless/tdlib/TdApi$GetStoryAvailableReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStoryAvailableReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AvailableReactions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x23854d3b


# instance fields
.field public rowSize:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13705
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 13695
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13696
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetStoryAvailableReactions;->rowSize:I

    .line 13697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13701
    const v0, 0x23854d3b

    return v0
.end method
