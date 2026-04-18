.class public Lorg/drinkless/tdlib/TdApi$FileTypeSelfDestructingVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$FileType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileTypeSelfDestructingVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x64d0db1d


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1980
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$FileType;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1985
    const v0, 0x64d0db1d

    return v0
.end method
