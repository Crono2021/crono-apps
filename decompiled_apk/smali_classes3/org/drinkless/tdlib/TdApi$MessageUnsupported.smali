.class public Lorg/drinkless/tdlib/TdApi$MessageUnsupported;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageUnsupported"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c490a7b


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4177
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4182
    const v0, -0x6c490a7b

    return v0
.end method
