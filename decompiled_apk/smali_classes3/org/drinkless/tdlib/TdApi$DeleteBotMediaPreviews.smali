.class public Lorg/drinkless/tdlib/TdApi$DeleteBotMediaPreviews;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteBotMediaPreviews"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x534c5a12


# instance fields
.field public botUserId:J

.field public fileIds:[I

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36565
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "iArr"    # [I

    .line 36553
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36554
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteBotMediaPreviews;->botUserId:J

    .line 36555
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteBotMediaPreviews;->languageCode:Ljava/lang/String;

    .line 36556
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$DeleteBotMediaPreviews;->fileIds:[I

    .line 36557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36561
    const v0, -0x534c5a12

    return v0
.end method
