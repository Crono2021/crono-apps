.class public Lorg/drinkless/tdlib/TdApi$TopChatCategoryCalls;
.super Lorg/drinkless/tdlib/TdApi$TopChatCategory;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TopChatCategoryCalls"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x153b50dd


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 7828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TopChatCategory;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 7833
    const v0, 0x153b50dd

    return v0
.end method
