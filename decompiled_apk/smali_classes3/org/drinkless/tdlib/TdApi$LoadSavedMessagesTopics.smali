.class public Lorg/drinkless/tdlib/TdApi$LoadSavedMessagesTopics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoadSavedMessagesTopics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1146d6b8


# instance fields
.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 16135
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16125
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 16126
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$LoadSavedMessagesTopics;->limit:I

    .line 16127
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16131
    const v0, 0x1146d6b8

    return v0
.end method
