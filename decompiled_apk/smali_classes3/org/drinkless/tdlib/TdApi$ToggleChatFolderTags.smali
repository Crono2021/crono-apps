.class public Lorg/drinkless/tdlib/TdApi$ToggleChatFolderTags;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatFolderTags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7cb493bc


# instance fields
.field public areTagsEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21369
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 21359
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21360
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatFolderTags;->areTagsEnabled:Z

    .line 21361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21365
    const v0, -0x7cb493bc

    return v0
.end method
