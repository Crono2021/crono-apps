.class public Lorg/drinkless/tdlib/TdApi$GetMessageFileType;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageFileType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageFileType;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1d38f02c


# instance fields
.field public messageFileHead:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13129
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13119
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13120
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageFileType;->messageFileHead:Ljava/lang/String;

    .line 13121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13125
    const v0, -0x1d38f02c

    return v0
.end method
