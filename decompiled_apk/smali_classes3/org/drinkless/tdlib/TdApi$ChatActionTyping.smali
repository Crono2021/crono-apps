.class public Lorg/drinkless/tdlib/TdApi$ChatActionTyping;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionTyping"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x16a83437


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1090
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1095
    const v0, 0x16a83437

    return v0
.end method
