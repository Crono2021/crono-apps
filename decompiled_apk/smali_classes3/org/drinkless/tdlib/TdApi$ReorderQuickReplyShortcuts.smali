.class public Lorg/drinkless/tdlib/TdApi$ReorderQuickReplyShortcuts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReorderQuickReplyShortcuts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a5b3b00


# instance fields
.field public shortcutIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18672
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18673
    return-void
.end method

.method public constructor <init>([I)V
    .locals 0
    .param p1, "iArr"    # [I

    .line 18663
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18664
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReorderQuickReplyShortcuts;->shortcutIds:[I

    .line 18665
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18669
    const v0, -0x7a5b3b00

    return v0
.end method
