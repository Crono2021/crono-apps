.class public Lorg/drinkless/tdlib/TdApi$ReactionTypePaid;
.super Lorg/drinkless/tdlib/TdApi$ReactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReactionTypePaid"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1a0152ed


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReactionType;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 5759
    const v0, 0x1a0152ed

    return v0
.end method
