.class public Lorg/drinkless/tdlib/TdApi$ChatSourceMtprotoProxy;
.super Lorg/drinkless/tdlib/TdApi$ChatSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatSourceMtprotoProxy"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x177d1803


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatSource;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1333
    const v0, 0x177d1803

    return v0
.end method
