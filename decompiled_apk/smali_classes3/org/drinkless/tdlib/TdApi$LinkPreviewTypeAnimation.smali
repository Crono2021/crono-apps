.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeAnimation;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x52a33acc


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15810
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15811
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;

    .line 15801
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15802
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 15803
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15807
    const v0, -0x52a33acc

    return v0
.end method
