.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreas;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreas"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x34a547f0


# instance fields
.field public areas:[Lorg/drinkless/tdlib/TdApi$InputStoryArea;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 15199
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$InputStoryArea;)V
    .locals 0
    .param p1, "inputStoryAreaArr"    # [Lorg/drinkless/tdlib/TdApi$InputStoryArea;

    .line 15189
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 15190
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreas;->areas:[Lorg/drinkless/tdlib/TdApi$InputStoryArea;

    .line 15191
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15195
    const v0, -0x34a547f0    # -1.4333968E7f

    return v0
.end method
