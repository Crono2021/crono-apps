.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoPaused;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallIsMyVideoPaused"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c8b0e67


# instance fields
.field public groupCallId:I

.field public isMyVideoPaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33289
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33279
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoPaused;->groupCallId:I

    .line 33280
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallIsMyVideoPaused;->isMyVideoPaused:Z

    .line 33281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33285
    const v0, -0x1c8b0e67

    return v0
.end method
